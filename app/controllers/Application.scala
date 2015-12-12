package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Redirect(routes.Application.tasks)
  }

  def tasks = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def addTask = TODO

  def deleteTask(id: Long) = TODO

}
