<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.java12.crmApp.util.UrlConst" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Role</title>
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
	                       <li class="breadcrumb-item"><a href="<c:url value="<%=UrlConst.ROLE_ADD %>" />">Role</a></li>
	                       <li class="breadcrumb-item active" aria-current="page">
	                            Update Role
	                       </li>
	                    </ol>
	                </nav>
	                <h1 class="m-0">Update Role</h1>
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
	                  <form action="<c:url value="<%=UrlConst.ROLE_UPDATE %>" />" method="post">
	                   <div class="form-group">
	                       <label for="id">Id:</label>
	                       <input type="text" class="form-control" name="id" id="id" value="${role.id}" readonly>
	                   </div>
	                   <div class="form-group">
	                       <label for="name">Name:</label>
	                       <input type="text" class="form-control" name="name" id="name" value="${role.name}">
	                   </div>
	                   <div class="form-group">
	                       <label for="description">Description:</label>
	                       <input type="text" class="form-control" name="description" id="description" value="${role.description}">
	                   </div>	                     
	                   <button class="btn btn-primary w-25 justify-content-center" type="submit">Update</button>
	               </form>
	           </div>
	       </div>
	   </div>
	</div>
<!-- End Body -->
</body>
</html>