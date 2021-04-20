<%--
- form.jsp
-
- Copyright (C) 2012-2021 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<h2>
	<acme:message code="administrator.dashboard.form.title.show"/>
</h2>

<table class="table table-sm">
	<caption>
		<acme:message code="administrator.dashboard.form.title.general-indicators"/>
	</caption>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.totalNumberOfPublicTasks"/>
		</th>
		<td>
			<acme:print value="${totalNumberOfPublicTasks}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.totalNumberOfPrivateTasks"/>
		</th>
		<td>
			<acme:print value="${totalNumberOfPrivateTasks}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.totalNumberOfFinishedTasks"/>
		</th>
		<td>
			<acme:print value="${totalNumberOfFinishedTasks}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.totalNumberOfNonFinishedTasks"/>
		</th>
		<td>
			<acme:print value="${totalNumberOfNonFinishedTasks}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.averageTaskExecutionPeriods"/>
		</th>
		<td>
			<acme:print value="${averageTaskExecutionPeriods}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviationTaskExecutionPeriods"/>
		</th>
		<td>
			<acme:print value="${deviationTaskExecutionPeriods}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minimumTaskExecutionPeriod"/>
		</th>
		<td>
			<acme:print value="${minimumTaskExecutionPeriod}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maximumTaskExecutionPeriod"/>
		</th>
		<td>
			<acme:print value="${maximumTaskExecutionPeriod}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.averageTaskWorkloads"/>
		</th>
		<td>
			<acme:print value="${averageTaskWorkloads}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviationTaskWorkloads"/>
		</th>
		<td>
			<acme:print value="${deviationTaskWorkloads}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minimumTaskWorkload"/>
		</th>
		<td>
			<acme:print value="${minimumTaskWorkload}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maximumTaskWorkload"/>
		</th>
		<td>
			<acme:print value="${maximumTaskWorkload}"/>
		</td>
	</tr>	
</table>