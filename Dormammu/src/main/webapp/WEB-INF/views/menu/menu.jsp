<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="memberInsertForm"><i class="fa fa-dashboard fa-fw"></i> Insert</a>
                        </li>
                        <li>
                            <a href="boardInsertForm"><i class="fa fa-bar-chart-o fa-fw"></i> Board</a>
                        </li>
                        <li>
                            <a href="memberList"><i class="fa fa-table fa-fw"></i> MemberList</a>
                        </li>
                        <li>
                            <a href="boardList"><i class="fa fa-edit fa-fw"></i> BoardList</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
 <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Salary Pages<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="salaryHome">SalaryInsert</a>
                                </li>
                                <li>
                                    <a href="salaryList">Salary List</a>
                                </li>
                                <li>
                                    <a href="salaryCreateForm">Monthly Salary Creation</a>
                                </li>
                                <li>
                                    <a href="salaryRollupForm">월별 급여 리스트</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
</nav>
</body>
</html>