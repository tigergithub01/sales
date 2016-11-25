package com.sales.util.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	private static CookieUtil instance = null;
	
	public static CookieUtil getInstance(){
		if(instance==null){
			instance =  new CookieUtil();
		}
		return instance;
	}
	
	
	/**
	 * 根据名字查找cookie
	 * @param request
	 * @param name
	 * @return
	 */
	public Cookie getCookie(HttpServletRequest request,String name ){
		Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            return null;
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                	return cookie;
                }
            }
        }
        return null;
    }
	
	/**
	 * 根据名字查找cookie的值
	 * @param request
	 * @param name
	 * @return
	 */
	public String getCookieValue(HttpServletRequest request,String name){
		Cookie cookie = this.getCookie(request, name);
		if(cookie==null){
			return null;
		}else{
			return cookie.getValue();
		}
    }
	
	/**
     * 读取所有cookie
     * 注意二、从客户端读取Cookie时，包括maxAge在内的其他属性都是不可读的，也不会被提交。浏览器提交Cookie时只会提交name与value属性。maxAge属性只被浏览器用来判断Cookie是否过期
     * @param request
     * @param response
     */
    public void showCookies(HttpServletRequest request,HttpServletResponse response ){
         
        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
        if (null==cookies) {
            System.out.println("没有cookie=========");
        } else {
            for(Cookie cookie : cookies){
                System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());
            }
        }
         
    }
    /**
     * 添加cookie
     * @param response
     * @param name
     * @param value
     */
    public void addCookie(HttpServletResponse response,String name,String value){
        Cookie cookie = new Cookie(name.trim(), value.trim());
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setPath("/");
        System.out.println("已添加===============");
        response.addCookie(cookie);
    }
    /**
     * 修改cookie
     * @param request
     * @param response
     * @param name
     * @param value
     * 注意一、修改、删除Cookie时，新建的Cookie除value、maxAge之外的所有属性，例如name、path、domain等，都要与原Cookie完全一样。否则，浏览器将视为两个不同的Cookie不予覆盖，导致修改、删除失败。
     */
    public void editCookie(HttpServletRequest request,HttpServletResponse response,String name,String value){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie==============");
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    System.out.println("原值为:"+cookie.getValue());
                    cookie.setValue(value);
                    cookie.setPath("/");
                    cookie.setMaxAge(30 * 60);// 设置为30min
                    System.out.println("被修改的cookie名字为:"+cookie.getName()+",新值为:"+cookie.getValue());
                    response.addCookie(cookie);
                    break;
                }
            }
        }
         
    }
    /**
     * 删除cookie
     * @param request
     * @param response
     * @param name
     */
    public void delCookie(HttpServletRequest request,HttpServletResponse response,String name){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie==============");
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setPath("/");
                    System.out.println("被删除的cookie名字为:"+cookie.getName());
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }
}
