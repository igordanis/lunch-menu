package sk.essentialdata.lunchmenu.restaurants

import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.model.Document
import sk.essentialdata.lunchmenu.{Dish, Restaurant, SimpleDish}

/**
  * @author miso
  */
case object Budvar extends Restaurant {
  def url: String = "http://www.budweiser-budvar.sk/jedalny-listok.php?lang=sk"

  override def parse(doc: Document): Seq[Dish] = {
    doc >> elementList("#jl-rozpis div") filter {_.attr("style").contains("Palatino")} map {_.text} map SimpleDish
  }
}
