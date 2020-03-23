package com.lx.security.controller;

import com.lx.security.algorithm.DES;
import com.lx.security.algorithm.MD5;
import com.lx.security.algorithm.RSA;
import com.lx.security.entity.StatusCode;
import com.lx.security.entity.TotalNote;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;


/**
 * test encryption
 * @author water
 *
 */
@Controller
public class TestRasAndDesController {
	
	//请求url: http://localhost:8080/testRsa.do?ciphertext=........
	@RequestMapping("testRsa.do")
	@ResponseBody
	public TotalNote testRas(String ciphertext){
		System.out.println("收到请求！");
		TotalNote note = new TotalNote();
		try{
			System.out.println(ciphertext);
			String decode = RSA.decryptByPrivateKey(ciphertext);
			BASE64Encoder base64Encoder = new BASE64Encoder();
			String s = base64Encoder.encodeBuffer(decode.getBytes());
			System.out.println("base64后"+s);
			System.out.println("解密后的字符串："+decode); 
		}catch(Exception e){
			e.printStackTrace();
		}  
		String data = "Hello World！";
		note.setError_code(StatusCode.SUCCESS_CODE);
		note.setData(data);
		return note;
	}
	
	/**
	 * 测试DES加密：
	 * 请求url: http://localhost:8080/testDes.do?ciphertext=.........
	 */
	@RequestMapping("testDes.do")
	@ResponseBody
	public TotalNote testDes(String ciphertext){
		System.out.println("收到请求！");
		TotalNote note = new TotalNote();
		try{
			System.out.println(ciphertext);
			String decode = DES.encryptDES(ciphertext, DES.PASSWORD_CRYPT_KEY);
			System.out.println("解密后的字符串："+decode); 
		}catch(Exception e){
			e.printStackTrace();
		}  
		String data = "Hello World！";
		note.setError_code(StatusCode.SUCCESS_CODE);
		note.setData(data);
		return note;
	}
	
	/**
	 * 将Des和Rsa结合使用：将desKey及关键字段（用户id）使用rsa公钥加密，传到服务器
	 * 服务器使用rsa私钥解密，获得desKey及用户id，并根据id查找用户余额，使用des加密后返回给客户端
	 * @param userId 用户id
	 * @return 用户的一些关键信息
	 */
	@RequestMapping("testRsaAndDes.do")
	@ResponseBody
	public TotalNote testRsaAndDes(String userId,String desKey){
		System.out.println("收到请求！");
		TotalNote note = new TotalNote();
		try{
			System.out.println(userId);
			//使用私钥解密
			userId = RSA.decryptByPrivateKey(userId);
			desKey = RSA.decryptByPrivateKey(desKey);
			
			//查找数据库获取用户，账户余额等关键字段，使用des进行加密
			String account = "10000.0";
			account = DES.encryptDES(account, desKey);
			
			note.setError_code(StatusCode.SUCCESS_CODE);
			note.setError_message("获取数据成功！");
			note.setData(account);
			return note;
		}catch(Exception e){
			e.printStackTrace();
			note.setError_code(StatusCode.ERROR_CODE);
			note.setError_message(StatusCode.ERROR_MESSAGE);
			return note;
		}  
	}
	
	/**
	 * 测试MD5加密
	 * 请求url：http://localhost:8080/testMd5.do?password=..........&md5=..........
	 * @param md5
	 * @return
	 */
	@RequestMapping("testMd5.do")
	@ResponseBody
	public TotalNote testMd5(String password,String md5){
		System.out.println("收到请求！");
		TotalNote note = new TotalNote();
		try{
			System.out.println("使用md5加密后的:"+md5);
			String md5Str = MD5.getMD5Code(password);
			if(md5Str.equals(md5)){
				System.out.println("密码验证成功！");
			}else{
				System.out.println("密码验证失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}  
		String data = "Hello World！";
		note.setError_code(StatusCode.SUCCESS_CODE);
		note.setData(data);
		return note;
	}

}
