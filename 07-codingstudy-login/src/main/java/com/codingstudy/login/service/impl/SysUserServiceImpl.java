package com.codingstudy.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codingstudy.login.components.BCryptPasswordEncoderUtil;
import com.codingstudy.login.dao.SysUserMapper;
import com.codingstudy.login.entity.SysUserEntity;
import com.codingstudy.login.service.SysUserService;
import com.codingstudy.login.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Autowired
    BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;

    //用户激活状态
    private static final int USER_STATE = 1;

    /**
     * 通过账号查询用户
     * @param username
     * @return
     */
    @Override
    public SysUserEntity getUserByUserName(String username) {
        LambdaQueryWrapper<SysUserEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //查询条件：全匹配账号名，和状态为1的账号
        lambdaQueryWrapper
                .eq(SysUserEntity::getUserName,username)
                .eq(SysUserEntity::getState,USER_STATE);

        //用getOne查询一个对象出来
        SysUserEntity user = this.getOne(lambdaQueryWrapper);

        return  user;
    }

    /**
     * 个性化验证登录
     * @param username 账号
     * @param rawPassword 原始密码
     * @return
     */
    @Override
    public boolean checkLogin(String username,String rawPassword) throws Exception {
        SysUserEntity userEntity = this.getUserByUserName(username);
        System.out.println("userEntity = " + userEntity);
        if (userEntity == null) {
            //System.out.println("checkLogin--------->账号不存在，请重新尝试！");
            //设置友好提示
            throw  new Exception("账号不存在，请重新尝试！");
        }else {
            //加密的密码
            String encodedPassword = userEntity.getPassWord();
            //和加密后的密码进行比配
            if(!bCryptPasswordEncoderUtil.matches(rawPassword,encodedPassword)) {
                //System.out.println("checkLogin--------->密码不正确！");
                //设置友好提示
                throw new Exception("密码不正确！");
            }else{
                return  true;
            }
        }
    }

    /**
     * 注册
     * @param sysUserVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean register(SysUserVo sysUserVo) throws Exception {
        if(sysUserVo !=null) {
            SysUserEntity f = this.getUserByUserName(sysUserVo.getName());
            if(f != null) {
                throw new Exception("这个用户已经存在，不能重复。");
            }
            //保存到数据库
            return  this.save(this.voToPo(sysUserVo));
        }else{
            throw new Exception("错误消息：用户对象为空！");
        }
    }

    /**
     * VO到PO的转换
     * @param vo
     * @return
     */
    public SysUserEntity voToPo(SysUserVo vo) {
        SysUserEntity po = new SysUserEntity();
        if(vo !=null) {
            po.setUserId(vo.getId());
            po.setUserName(vo.getName());
            po.setDescription(vo.getDes());
            //对密码进行加密
            po.setPassWord(bCryptPasswordEncoderUtil.encode(vo.getPassw()));
            //设置状态为1
            po.setState(USER_STATE);
        }
        return po;
    }
}
