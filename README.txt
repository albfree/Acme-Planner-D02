# README.txt
#
# Copyright (C) 2012-2021 Rafael Corchuelo.
#
# In keeping with the traditional purpose of furthering education and research, it is
# the policy of the copyright owner to permit non-commercial use and redistribution of
# this software. It has been tested carefully, but it is not guaranteed for any particular
# purposes.  The copyright owner does not offer any warranties or representations, nor do
# they accept any liabilities with respect to them.

This is the Starter Project, which is intended to be a core learning asset for the students
who have enroled the Design and Testing subject of the Software Engineering curriculum of the 
University of Sevilla.  This project helps them start working on their new information system 
projects.

This is Acme Planner, the second project of Group 11 for Design & Testing 2 subject.

GitHub repository: https://github.com/albgueram/Acme-Planner-D02
GitHub release: 


Interpretaciones:

- Al no concretarse en los requisitos lo contrario, se interpreta que no es necesario incluir @Past para
el atributo 'moment' de la entidad Shout. Al realizarse la creación de un Shout, siempre
estará en pasado porque así se ha implementado en el servicio correspondiente. La decisión de no incluir 
@Past se toma para poder introducir ejemplos de la entidad Shout con fecha de creación posterior a la del entregable, 
de forma que se simplifica la corrección al profesor al listar Shouts.

- No se dejará eliminar una tarea mientras pertenezca a un WorkPlan, se mostrará un mensaje de información que
avise al usuario de que debe eliminar primero la tarea de la lista de tareas de los WorkPlans a los que pertenezca.

- Aunque no se solicita en los requisitos, se añade un atributo título a la entidad WorkPlan para facilitar la
identificación al listar y mostrar.