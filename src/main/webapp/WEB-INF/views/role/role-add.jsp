<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.java12.crmApp.util.UrlConst" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new role</title>
</head>
<body>
<!-- Breadcrumb -->
	<div class="container page__heading-container">
	    <div class="page__heading">
	        <div class="d-flex align-items-center">
	            <div>
	                <nav aria-label="breadcrumb">
	                    <ol class="breadcrumb mb-0">
	                        <li class="breadcrumb-item"><a href="<c:url value="<%=UrlConst.HOME %>" />">Home</a></li>
	                        <li class="breadcrumb-item"><a href="<c:url value="<%=UrlConst.ROLE_DASHBOARD %>" />">Role</a></li>
	                        <li class="breadcrumb-item active" aria-current="page">
	                            Add New Role
	                        </li>
	                    </ol>
	                </nav>
	                <h1 class="m-0">Add New Role</h1>
	            </div>
	        </div>
	    </div>
	</div>
<!-- End Breadcrumb -->
<!-- Start Body -->	
	<div class="container page__container">
		<div class="card card-form">
	          <div class="row no-gutters">
	              <div class="col-lg-4 card-body">
	                  <p><strong class="headings-color">Rules</strong></p>
	                  <p class="text-muted">There is no rule!</p>
	              </div>
	              <div class="col-lg-8 card-form__body card-body">
	                  <form action="<c:url value="<%=UrlConst.ROLE_ADD %>" />" method="post">
	                   <div class="form-group">
	                       <label for="id">ID:</label>
	                       <input type="text" class="form-control" name="id" id="id">
	                   </div>
	                   <div class="form-group">
	                       <label for="name">Name:</label>
	                       <input type="text" class="form-control" name="name" id="name">
	                   </div>
	                   <div class="form-group">
	                       <label for="description">Description:</label>
	                       <input type="text" class="form-control" name="description" id="description">
	                   </div>	                   	                                   
	                   <button class="btn btn-primary w-25 justify-content-center" type="submit">Add</button>
	               	</form>
	           </div>
	       </div>
	   </div>
	</div>
<!-- End Body -->
</body>
</html>