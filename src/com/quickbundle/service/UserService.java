package com.quickbundle.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
import com.quickbundle.vo.ReceiptInfo;
import com.quickbundle.vo.UserInfo;

@Path("userService")
public class UserService {

	@GET
	@Path("loginUser")
	@Produces("application/json")
	@Consumes("application/json")
	public String loginUser(@QueryParam("userName") String userName,
			@QueryParam("userPass") String userPass,
			@QueryParam("jsoncallback") String jsoncallback) {
		String json = "";
		if(userName !=null &&
				userPass != null &&
				userName.equals("admin")&&
				userPass.equals("admin")){
			UserInfo user = new UserInfo();
			user.setId(1);
			user.setName("admin");
			user.setPassword("admin");
			user.setRole("admin");
			System.out.println(jsoncallback);
			Gson gson = new Gson();
			json = gson.toJson(user);
		}else{
			UserInfo user = new UserInfo();
			user.setId(1);
			user.setName("error"+jsoncallback);
			user.setPassword("error"+jsoncallback);
			user.setRole("error"+jsoncallback);
			System.out.println(jsoncallback);
			Gson gson = new Gson();
			json = gson.toJson(user);
		}
		
		return jsoncallback+"("+json+")";
	}
	@GET
	@Path("getReceiptInfo")
	@Produces("application/json")
	@Consumes("application/json")
	public String getReceiptInfo(
			@QueryParam("receiptApplicant") String receiptApplicant,
			@QueryParam("receiptNum") String receiptNum,
			@QueryParam("receiptFrom") String receiptFrom,
			@QueryParam("receiptTo") String receiptTo,
			@QueryParam("jsoncallback") String jsoncallback) {
		if(receiptApplicant!=null && receiptNum.equals("")){
			ArrayList<ReceiptInfo> list = new ArrayList<ReceiptInfo>();
			ReceiptInfo receipt1 = new ReceiptInfo();
			receipt1.setReceiptApplicant("admin");
			receipt1.setReceiptDate("2013-06-11");
			receipt1.setReceiptNum("1");
			receipt1.setReceiptDetail("2013��6��1��~2013��6��10�ձ����������������2800Ԫ��");
			receipt1.setReceiptTitle("2013��6��1�ձ�������");
			list.add(receipt1);
			ReceiptInfo receipt2 = new ReceiptInfo();
			receipt2.setReceiptApplicant("admin");
			receipt2.setReceiptNum("2");
			receipt2.setReceiptDate("2013-06-11");
			receipt2.setReceiptDetail("2013��5��1��~2013��5��10�ձ����������������4800Ԫ��");
			receipt2.setReceiptTitle("2013��5��1�ձ�������");
			list.add(receipt2);
			Gson gson = new Gson();
			String json = gson.toJson(list);
			return jsoncallback+"("+json+")";
		}
		if(receiptNum != null){
			ReceiptInfo receipt1 = new ReceiptInfo();
			receipt1.setReceiptApplicant("admin");
			receipt1.setReceiptDate("2013-06-11");
			receipt1.setReceiptNum("1");
			receipt1.setReceiptDetail("2013��6��1��~2013��6��10�ձ����������������2800Ԫ��");
			receipt1.setReceiptTitle("2013��6��1�ձ�������");
			Gson gson = new Gson();
			String json = gson.toJson(receipt1);
			return jsoncallback+"("+json+")";
		}

		throw new UnsupportedOperationException("Not yet implemented.");
	}
	@GET
	@Path("saveReceiptInfo")
	@Produces("application/json")
	@Consumes("application/json")
		public String saveReceiptInfo(
			@QueryParam("receiptApplicant") String receiptApplicant,
			@QueryParam("receiptDate") String receiptDate,
			@QueryParam("receiptTitle") String receiptTitle,
			@QueryParam("receiptDetail") String receiptDetail,
			@QueryParam("jsoncallback") String jsoncallback) {
		System.out.println("receipt is saved!" + receiptApplicant + " " + receiptTitle + " " +receiptDetail);
		Gson gson = new Gson();
		String json = gson.toJson("success!");
		return jsoncallback+"("+json+")";
	}
	@GET
	@Path("deleteReceiptInfo")
	@Produces("application/json")
	@Consumes("application/json")
		public String deleteReceiptInfo(
			@QueryParam("receiptNum") String receiptNum,
			@QueryParam("jsoncallback") String jsoncallback) {
		System.out.println("receipt is delete!" + receiptNum);
		Gson gson = new Gson();
		String json = gson.toJson("delete success!");
		return jsoncallback+"("+json+")";
	}
}
