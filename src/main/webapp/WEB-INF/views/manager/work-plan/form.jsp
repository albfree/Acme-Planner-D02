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
	<jstl:if test="${hasTasks}">
	<acme:message code="${suggestedMessage}"/>
	</jstl:if>
	
	<acme:form-moment code="manager.work-plan.form.label.startExecutionPeriod" path="startExecutionPeriod"/>
	<acme:form-moment code="manager.work-plan.form.label.endExecutionPeriod" path="endExecutionPeriod"/>
	
	<acme:form-select code="manager.work-plan.form.label.share" path="share">
		<acme:form-option code="PUBLIC" value="PUBLIC" selected="${share == 'PUBLIC'}"/>
		<acme:form-option code="PRIVATE" value="PRIVATE" selected="${share == 'PRIVATE'}"/>
	</acme:form-select>
	
	<jstl:if test="${command != 'create'}">
	<acme:form-double readonly="true" code="manager.work-plan.form.label.total-workload" path="totalWorkload"/>
	</jstl:if>
	
	<acme:form-submit test="${command == 'create'}" code="manager.work-plan.form.button.create" 
		action="create"/>
	<acme:form-submit test="${command != 'create'}" code="manager.work-plan.form.button.update" 
		action="update"/>
	<acme:form-submit test="${command != 'create'}" code="manager.work-plan.form.button.delete" 
		action="delete"/>
		
  	<acme:form-return code="manager.work-plan.form.button.return"/>
</acme:form>