<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    
    
      

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </head>
<body>

    <jsp:include page="header.jsp" />
<br> <br>
<br>

<h1 style="text-align:center">Rest Template Consumer Application</h1>
    <div class="container mt-4">
        <div class="d-flex justify-content-between mb-4">
            <h1>Employee List</h1>
            <a href="/addemployee" class="btn btn-primary">Add Employee</a>
        </div>
        
       
        
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Salary</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    
                    
                </tr>
            </thead>
            <tbody>
                <!-- JSTL to check if employees list is not empty -->
                <c:if test="${not empty employees}">
                    <!-- JSTL to iterate over the list of employees -->
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td>${employee.id}</td>
                            <td>${employee.employee_name}</td>
                            <td>${employee.salary}</td>
                            <td>
							<form action="/employeeUpdateForm/${employee.id}" method=get>
							<input type="submit" class="btn btn-primary" value="Edit">
							</form>
							</td>
							<td>
							<form action="/employee/${employee.id}" method=post>
							<input type="submit" class="btn btn-danger" value="Delete">
							</form>
							</td>
							

						</tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty employees}">
                    <tr>
                        <td colspan="3" class="text-center">No employees available.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    
        <jsp:include page="footer.jsp" />
    
</body>
</html>
