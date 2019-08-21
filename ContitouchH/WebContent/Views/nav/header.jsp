<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

								<div class="row">
									<div class="col-sm-6 mb-4 mb-xl-0">
										<h3>Project Tracking System</h3>
										<h6 class="font-weight-normal mb-0 text-muted">Dashboard...</h6>
									</div>
									<div class="col-sm-6">
										<div class="d-flex align-items-center justify-content-md-end">
											<div class="border-right-dark pr-4 mb-3 mb-xl-0 d-xl-block d-none">
												<p class="text-muted">Current Date Time</p>
												<%@ page import="java.util.*" %>
												<h6 class="font-weight-medium text-dark mb-0"><%= (new java.util.Date()).toLocaleString()%></h6>
											</div>
											<div class="pr-4 pl-4 mb-3 mb-xl-0 d-xl-block d-none">
												
											</div>
											
											<div class="pr-1 mb-3 mb-xl-0 d-xl-block d-none">
												<button type="button" class="btn btn-success btn-icon mr-2"><i class="mdi mdi-desktop-mac"></i></button>
												 <!-- onclick="window.location.href = 'alljobs.jsp';" -->
											</div>
											
										</div>
									</div>
								</div>
								<div class="page-header-tab mt-xl-4">
									<div class="col-12 pl-0 pr-0">
										<div class="row ">
											<div class="col-12 col-sm-6 mb-xs-4  pt-2 pb-2 mb-xl-0">
												<ul class="nav nav-tabs tab-transparent" role="tablist">
													<li class="nav-item">
														<a class="nav-link active" id="overview-tab" data-toggle="tab" href="#" role="tab" aria-controls="overview" aria-selected="true">Project</a>
													</li>
													<li class="nav-item">
														<a class="nav-link" id="users-tab" data-toggle="tab" href="#" role="tab" aria-controls="users" aria-selected="false">Tracking</a>
													</li>
													<li class="nav-item">
														<a class="nav-link" id="returns-tab" data-toggle="tab" href="#" role="tab" aria-controls="returns" aria-selected="false">System</a>
													</li>
													
												</ul>
											</div>
									 		<div class="col-12 col-sm-6 mb-xs-4 mb-xl-0 pt-2 pb-2 text-md-right d-none d-md-block">
												<div class="d-inline-flex">
													<button class="btn d-flex align-items-center">
													<i class="mdi mdi-account mr-1"></i>
													<span class="text-left font-weight-medium">
													<%String loggedinas =  session.getAttribute("User").toString(); %>
													<%out.print(loggedinas); %>
													</span>
													</button>
													<!-- <button class="btn d-flex align-items-center">
													<i class="mdi mdi-file-pdf  mr-1"></i>
													<span class="font-weight-medium text-left">
													PDF reports
													</span>
													</button> -->
													
												</div>
											</div>
										</div>
									</div>
								</div>
								

</html>