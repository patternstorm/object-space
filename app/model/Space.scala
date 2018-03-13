package model

import model.individuals._
import model.statements.{Assertables, Derivables, Facts, Propositions}

trait Space extends Individuals with Particulars with Qualities with Relations
  with Propositions with Assertables with Derivables with Facts {
}
