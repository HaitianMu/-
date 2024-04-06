package com.example.prj.companydetails.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 09
 * @since 2023-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Shareholders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("stockNumber")
    private String stockNumber;

    @TableField("fullName")
    private String fullName;

    private Integer rank1;

    @TableField("holderName")
    private String holderName;

    @TableField("holdAmount")
    private String holdAmount;

    @TableField("holdRate")
    private Double holdRate;


}
