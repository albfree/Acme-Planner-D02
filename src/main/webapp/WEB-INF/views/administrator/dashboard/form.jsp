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

<acme:form>

	<acme:form-integer code="administrator.dashboard.form.label.totalNumberOfPublicTasks" path="totalNumberOfPublicTasks"/>
	<acme:form-integer code="administrator.dashboard.form.label.totalNumberOfPrivateTasks" path="totalNumberOfPrivateTasks"/>
	<acme:form-integer code="administrator.dashboard.form.label.totalNumberOfFinishedTasks" path="totalNumberOfFinishedTasks"/>
	<acme:form-integer code="administrator.dashboard.form.label.totalNumberOfNonFinishedTasks" path="totalNumberOfNonFinishedTasks"/>
	<acme:form-double code="administrator.dashboard.form.label.averageTaskExecutionPeriods" path="averageTaskExecutionPeriods"/>
	<acme:form-double code="administrator.dashboard.form.label.deviationTaskExecutionPeriods" path="deviationTaskExecutionPeriods"/>
	<acme:form-double code="administrator.dashboard.form.label.minimumTaskExecutionPeriod" path="minimumTaskExecutionPeriod"/>
	<acme:form-double code="administrator.dashboard.form.label.maximumTaskExecutionPeriod" path="maximumTaskExecutionPeriod"/>
	<acme:form-double code="administrator.dashboard.form.label.averageTaskWorkloads" path="averageTaskWorkloads"/>
	<acme:form-double code="administrator.dashboard.form.label.deviationTaskWorkloads" path="deviationTaskWorkloads"/>
	<acme:form-double code="administrator.dashboard.form.label.minimumTaskWorkload" path="minimumTaskWorkload"/>
	<acme:form-double code="administrator.dashboard.form.label.maximumTaskWorkload" path="maximumTaskWorkload"/>
	
</acme:form> 
