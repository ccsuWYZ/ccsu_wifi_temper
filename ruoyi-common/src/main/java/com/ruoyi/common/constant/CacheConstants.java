package com.ruoyi.common.constant;

/**
 * 缓存的key 常量
 * 
 * @author ruoyi
 */
public class CacheConstants
{
    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 防重提交 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 限流 redis key
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * 登录账户密码错误次数 redis key
     */
    public static final String PWD_ERR_CNT_KEY = "pwd_err_cnt:";

  /*
  工厂信息 redis key
   */
    public static final String FAC_INFO_KEY="fac_info:";


    /*
 车间信息 redis key
  */
    public static final String WORKSHOP_INFO_KEY="workshop_info:";


    /*
电解槽信息 redis key
*/
    public static final String ELECELL_INFO_KEY="eleCell_info:";

    /*
热电偶信息 redis key
*/
    public static final String THERMOCOUPLE_INFO_KEY="thermocouple_info:";
    /*
设备信息 redis key
*/
    public static final String DEVICE_INFO_KEY="device_info:";
}
