package com.hzpicc.twoDcode.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WordCols {
    //序号	注册代码	安装位置	层站	型号	维保单位	使用单位	速度（M/S）	额定载重量	保费/元
    private String xvhao;
    private String idcode;
    private String position;
    private String floor;
    private String xinghao;
    private String weibaodanwei;
    private String shiyongdanwei;  //物业名称
    private String sudu;
    private String zaizhong;
    private String baofei;
    private String shebeimingcheng;// 小区名称
}
