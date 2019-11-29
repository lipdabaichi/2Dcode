package com.hzpicc.twoDcode.pojo;

import lombok.Data;
import lombok.experimental.Accessors;


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

    public String getXvhao() {
        return xvhao;
    }

    public void setXvhao(String xvhao) {
        this.xvhao = xvhao;
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getXinghao() {
        return xinghao;
    }

    public void setXinghao(String xinghao) {
        this.xinghao = xinghao;
    }

    public String getWeibaodanwei() {
        return weibaodanwei;
    }

    public void setWeibaodanwei(String weibaodanwei) {
        this.weibaodanwei = weibaodanwei;
    }

    public String getShiyongdanwei() {
        return shiyongdanwei;
    }

    public void setShiyongdanwei(String shiyongdanwei) {
        this.shiyongdanwei = shiyongdanwei;
    }

    public String getSudu() {
        return sudu;
    }

    public void setSudu(String sudu) {
        this.sudu = sudu;
    }

    public String getZaizhong() {
        return zaizhong;
    }

    public void setZaizhong(String zaizhong) {
        this.zaizhong = zaizhong;
    }

    public String getBaofei() {
        return baofei;
    }

    public void setBaofei(String baofei) {
        this.baofei = baofei;
    }

    public String getShebeimingcheng() {
        return shebeimingcheng;
    }

    public void setShebeimingcheng(String shebeimingcheng) {
        this.shebeimingcheng = shebeimingcheng;
    }

    @Override
    public String toString() {
        return "WordCols{" +
                "xvhao='" + xvhao + '\'' +
                ", idcode='" + idcode + '\'' +
                ", position='" + position + '\'' +
                ", floor='" + floor + '\'' +
                ", xinghao='" + xinghao + '\'' +
                ", weibaodanwei='" + weibaodanwei + '\'' +
                ", shiyongdanwei='" + shiyongdanwei + '\'' +
                ", sudu='" + sudu + '\'' +
                ", zaizhong='" + zaizhong + '\'' +
                ", baofei='" + baofei + '\'' +
                ", shebeimingcheng='" + shebeimingcheng + '\'' +
                '}';
    }
}
