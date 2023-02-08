package com.hrm.entity.PO;

import lombok.Data;

/**
 * 招聘渠道表
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-09 18:26
 * @Version: 1.0
 */
@Data
public class ChannelPO {

    private Integer channel_id;
    private Integer is_sys;
    private Integer status;
    private String value;

}
