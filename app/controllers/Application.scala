package controllers

import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import models.Task
import play.api.i18n.Messages.Implicits._
import play.api.Play.current


class Application extends Controller {

  val taskForm = Form(
    "label" -> nonEmptyText
  )


  def index = Action {
    Redirect(routes.Application.tasks)
  }

  def tasks = Action {
    Ok(views.html.index(Task.all(), taskForm))
  }

  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(Task.all(), errors)),
      label => {
        Task.create(label)
        Redirect(routes.Application.tasks)
      }
    )
  }

  def deleteTask(id: Long) = Action {
    Task.delete(id)
    Redirect(routes.Application.tasks)
  }


}
