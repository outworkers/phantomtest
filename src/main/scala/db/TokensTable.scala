package db

import com.outworkers.phantom.dsl._
import model.Token

abstract class TokensTable extends Table[TokensStore, Token] {
   object email extends StringColumn
   object token extends UUIDColumn with PartitionKey {
      override val name = "tokenuid"
   }
   object counter extends IntColumn
}