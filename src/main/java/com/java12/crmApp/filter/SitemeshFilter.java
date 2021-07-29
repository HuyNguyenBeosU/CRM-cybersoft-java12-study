package com.java12.crmApp.filter;

import javax.servlet.annotation.WebFilter;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@WebFilter(filterName = "sitemesh", urlPatterns = "/*") // /* nghia la tat ca cac trang deu qua trang sitemesh nay roi moi tra kq ve cho nguoi dung
public class SitemeshFilter extends SiteMeshFilter {

}
