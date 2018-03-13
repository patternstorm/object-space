package model

import model.statements.{Assertables, Derivables, Propositions}

trait Space extends Individuals with Propositions with Assertables with Derivables with Facts {
}
