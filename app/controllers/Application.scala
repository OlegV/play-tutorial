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

  def newTask = TODO

  def deleteTask(id: Long) = TODO



}
