<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Project</title>
</head>
<body>
<div class="container page__heading-container">
	<div class="card card-form">
	        <div class="card-body">
	            <form>
	                <div class="was-validated">
	                	<div class="form-row">
	                        <div class="col-12 col-md-20 mb-3">
	                            <label for="nameProject">Name Project</label>
	                            <input type="text" class="form-control" id="" placeholder="Name Project" value="" required="">
	                            <div class="invalid-feedback">Please provide a name.</div>
	                            <div class="valid-feedback">Looks good!</div>
	                        </div>
	                    </div>
	                    <div class="form-row">
	                        <div class="col-12 col-md-20 mb-3">     
                                <label for="dateStartProject">Date-Start Project</label>
                                <input id="" type="date" class="form-control" placeholder="US date: 00/00/0000" data-mask="00/00/0000">
	                        </div>
	                    </div>
	                    <div class="form-row">
	                        <div class="col-12 col-md-20 mb-3">     
                                <label for="dateEndProject">Date-End Project</label>
                                <input id="" type="date" class="form-control" placeholder="US date: 00/00/0000" data-mask="00/00/0000">
	                        </div>
	                    </div>                    
	                    <div class="form-row">
	                        <div class="col-12 col-md-20 mb-3">
	                            <label for="descriptionProject">Description Project</label>
	                            <input type="text" class="form-control" id="" placeholder="description" value="" required="">
	                            <div class="invalid-feedback">Please provide description.</div>
	                            <div class="valid-feedback">Looks good!</div>	                          
	                        </div>
	                    </div>
	                    <div class="form-row">
	                        <div class="col-12 col-md-20 mb-3">
	                            <label for="ownerProject">Owner Project</label>
	                            <input type="text" class="form-control" id="" placeholder="Owner" value="" required="">
	                            <div class="invalid-feedback">Please provide owner.</div>
	                            <div class="valid-feedback">Looks good!</div>
	                        </div>
	                    </div>
	                </div>
	                <button class="btn btn-primary" type="submit">Add New Project</button>
	            </form>
	        </div>
	    </div>
</div>
</body>
</html>