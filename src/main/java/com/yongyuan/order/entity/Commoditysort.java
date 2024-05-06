package com.yongyuan.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author fengsheming
 * @since 2024-05-06
 */
@Getter
@Setter
  @TableName("commoditysort")
public class Commoditysort implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId("id")
      private Integer id;

    @TableField("name")
    private String name;


}
