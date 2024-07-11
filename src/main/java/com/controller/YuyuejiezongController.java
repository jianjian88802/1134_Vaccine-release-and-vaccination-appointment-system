
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 预约接种
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yuyuejiezong")
public class YuyuejiezongController {
    private static final Logger logger = LoggerFactory.getLogger(YuyuejiezongController.class);

    @Autowired
    private YuyuejiezongService yuyuejiezongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YimiaoService yimiaoService;
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private YishengService yishengService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = yuyuejiezongService.queryPage(params);

        //字典表数据转换
        List<YuyuejiezongView> list =(List<YuyuejiezongView>)page.getList();
        for(YuyuejiezongView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YuyuejiezongEntity yuyuejiezong = yuyuejiezongService.selectById(id);
        if(yuyuejiezong !=null){
            //entity转view
            YuyuejiezongView view = new YuyuejiezongView();
            BeanUtils.copyProperties( yuyuejiezong , view );//把实体数据重构到view中

                //级联表
                YimiaoEntity yimiao = yimiaoService.selectById(yuyuejiezong.getYimiaoId());
                if(yimiao != null){
                    BeanUtils.copyProperties( yimiao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYimiaoId(yimiao.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(yuyuejiezong.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuejiezongEntity yuyuejiezong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yuyuejiezong:{}",this.getClass().getName(),yuyuejiezong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yuyuejiezong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YuyuejiezongEntity> queryWrapper = new EntityWrapper<YuyuejiezongEntity>()
            .eq("yonghu_id", yuyuejiezong.getYonghuId())
            .eq("yimiao_id", yuyuejiezong.getYimiaoId())
            .eq("yuyuejiezong_time", new SimpleDateFormat("yyyy-MM-dd").format(yuyuejiezong.getYuyuejiezongTime()))
            .eq("yuyuejiezong_text", yuyuejiezong.getYuyuejiezongText())
            .eq("yuyuejiezong_yesno_types", yuyuejiezong.getYuyuejiezongYesnoTypes())
            .eq("yuyuejiezong_yesno_text", yuyuejiezong.getYuyuejiezongYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuyuejiezongEntity yuyuejiezongEntity = yuyuejiezongService.selectOne(queryWrapper);
        if(yuyuejiezongEntity==null){
            yuyuejiezong.setYuyuejiezongYesnoTypes(1);
            yuyuejiezong.setCreateTime(new Date());
            yuyuejiezongService.insert(yuyuejiezong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuyuejiezongEntity yuyuejiezong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yuyuejiezong:{}",this.getClass().getName(),yuyuejiezong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            yuyuejiezong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YuyuejiezongEntity> queryWrapper = new EntityWrapper<YuyuejiezongEntity>()
            .notIn("id",yuyuejiezong.getId())
            .andNew()
            .eq("yonghu_id", yuyuejiezong.getYonghuId())
            .eq("yimiao_id", yuyuejiezong.getYimiaoId())
            .eq("yuyuejiezong_time", yuyuejiezong.getYuyuejiezongTime())
            .eq("yuyuejiezong_text", yuyuejiezong.getYuyuejiezongText())
            .eq("yuyuejiezong_yesno_types", yuyuejiezong.getYuyuejiezongYesnoTypes())
            .eq("yuyuejiezong_yesno_text", yuyuejiezong.getYuyuejiezongYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuyuejiezongEntity yuyuejiezongEntity = yuyuejiezongService.selectOne(queryWrapper);
        if(yuyuejiezongEntity==null){
            yuyuejiezongService.updateById(yuyuejiezong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yuyuejiezongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<YuyuejiezongEntity> yuyuejiezongList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YuyuejiezongEntity yuyuejiezongEntity = new YuyuejiezongEntity();
//                            yuyuejiezongEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yuyuejiezongEntity.setYimiaoId(Integer.valueOf(data.get(0)));   //疫苗 要改的
//                            yuyuejiezongEntity.setYuyuejiezongTime(new Date(data.get(0)));          //预约日期 要改的
//                            yuyuejiezongEntity.setYuyuejiezongText(data.get(0));                    //预约备注 要改的
//                            yuyuejiezongEntity.setYuyuejiezongYesnoTypes(Integer.valueOf(data.get(0)));   //预约审核 要改的
//                            yuyuejiezongEntity.setYuyuejiezongYesnoText(data.get(0));                    //审核原因 要改的
//                            yuyuejiezongEntity.setCreateTime(date);//时间
                            yuyuejiezongList.add(yuyuejiezongEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yuyuejiezongService.insertBatch(yuyuejiezongList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = yuyuejiezongService.queryPage(params);

        //字典表数据转换
        List<YuyuejiezongView> list =(List<YuyuejiezongView>)page.getList();
        for(YuyuejiezongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YuyuejiezongEntity yuyuejiezong = yuyuejiezongService.selectById(id);
            if(yuyuejiezong !=null){


                //entity转view
                YuyuejiezongView view = new YuyuejiezongView();
                BeanUtils.copyProperties( yuyuejiezong , view );//把实体数据重构到view中

                //级联表
                    YimiaoEntity yimiao = yimiaoService.selectById(yuyuejiezong.getYimiaoId());
                if(yimiao != null){
                    BeanUtils.copyProperties( yimiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYimiaoId(yimiao.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(yuyuejiezong.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuejiezongEntity yuyuejiezong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yuyuejiezong:{}",this.getClass().getName(),yuyuejiezong.toString());
        Wrapper<YuyuejiezongEntity> queryWrapper = new EntityWrapper<YuyuejiezongEntity>()
            .eq("yonghu_id", yuyuejiezong.getYonghuId())
            .eq("yimiao_id", yuyuejiezong.getYimiaoId())
            .eq("yuyuejiezong_text", yuyuejiezong.getYuyuejiezongText())
            .eq("yuyuejiezong_yesno_types", yuyuejiezong.getYuyuejiezongYesnoTypes())
            .eq("yuyuejiezong_yesno_text", yuyuejiezong.getYuyuejiezongYesnoText())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuyuejiezongEntity yuyuejiezongEntity = yuyuejiezongService.selectOne(queryWrapper);
        if(yuyuejiezongEntity==null){
            yuyuejiezong.setYuyuejiezongYesnoTypes(1);
            yuyuejiezong.setCreateTime(new Date());
        yuyuejiezongService.insert(yuyuejiezong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
