package zkTestGAE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

public class testVM implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1864764761422389075L;
	double dsvalue = 8.0;
	protected ListModel<String> sendTypes;
	protected String selSendType;
	Pattern pattern = Pattern.compile("[^0-9]");
	String txt1,txt2;
	int v1,v2,v3,v4,hv1,hv2,vv1,vv2,tv;
	
	public int getV1() {
		return v1;
	}
	public void setV1(int v1) {
		this.v1 = v1;
	}
	public int getV2() {
		return v2;
	}
	public void setV2(int v2) {
		this.v2 = v2;
	}
	public int getV3() {
		return v3;
	}
	public void setV3(int v3) {
		this.v3 = v3;
	}
	public int getV4() {
		return v4;
	}
	public void setV4(int v4) {
		this.v4 = v4;
	}
	@DependsOn({"v1","v2"})
	public int getHv1() {
		hv1=v1+v2;
		return hv1;
	}
	public void setHv1(int hv1) {
		this.hv1 = hv1;
	}
	@DependsOn({"v3","v4"})
	public int getHv2() {
		hv2=v3+v4;
		return hv2;
	}
	
	public void setHv2(int hv2) {
		this.hv2 = hv2;
	}
	@DependsOn({"v1","v3"})
	public int getVv1() {
		vv1=v1+v3;
		return vv1;
	}
	public void setVv1(int vv1) {
		this.vv1 = vv1;
	}
	@DependsOn({"v2","v4"})
	public int getVv2() {
		vv2=v2+v4;
		return vv2;
	}
	public void setVv2(int vv2) {
		this.vv2 = vv2;
	}
	@DependsOn({"hv1","hv2"})
	public int getTv(){
		tv = hv1+hv2;
		return tv;
	}
	@Command
	@NotifyChange("txt1")
	public void numberOnly(@BindingParam("arg") String txtv1){
		Matcher matcher = pattern.matcher(txtv1); // your string
		txtv1=matcher.replaceAll("").trim();// alert(newValue);
	}
	@Command
	@NotifyChange("txt2")
	public void onlyNumber(@BindingParam("arg") String txtv1){
		Matcher matcher = pattern.matcher(txtv1); // your string
		txtv1=matcher.replaceAll("").trim();// alert(newValue);
	}
	@Command
	@NotifyChange("dsvalue")
	public void tenTimes(@BindingParam("ds") Doublespinner ds,@BindingParam("v") String v,@ContextParam(ContextType.TRIGGER_EVENT) InputEvent ie ){
			
			String nextS = ie.getValue();
			if ("".equals(nextS)) {// alert("Empty"); 			
				dsvalue=60.0;
			} else { //alert(nextS);
				Double nextV = Double.parseDouble(nextS);
				dsvalue=nextV * 10;
			}
				ds.invalidate();
		}

	public double getDsvalue() {
		return dsvalue;
	}

	public void setDsvalue(double dsvalue) {
		this.dsvalue = dsvalue;
	}

	public ListModel<String> getSendTypes() {
		if(sendTypes==null){
			List<String> temp = new ArrayList<String>();
			temp.add("1.A");
			temp.add("2.B");
			temp.add("3.C");
			sendTypes = new ListModelList<String>(temp);
			selSendType = sendTypes.getElementAt(0);
		}
		return sendTypes;
	}

	public void setSendTypes(ListModel<String> sendTypes) {
		this.sendTypes = sendTypes;
	}

	public String getSelSendType() {
		return selSendType;
	}

	public void setSelSendType(String selSendType) {
		this.selSendType = selSendType;
	}
	public String getTxt1() {
		return txt1;
	}
	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}
	public String getTxt2() {
		return txt2;
	}
	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}
	}

