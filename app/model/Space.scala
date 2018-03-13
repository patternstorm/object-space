package model

import model.individuals.{Individuals, Particulars}
import model.statements.{Assertables, Derivables, Propositions}

trait Space extends Individuals with Particulars with Propositions with Assertables with Derivables with Facts {
}
