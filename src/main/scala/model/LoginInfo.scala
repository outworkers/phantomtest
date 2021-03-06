package model

import com.outworkers.phantom.builder.primitives.Primitive

/**
 * Represents a linked login for an identity (i.e. a local username/password or a Facebook/Google account).
 *
 * The login info contains the data about the provider that authenticated that identity.
 *
 * @param providerID The ID of the provider.
 * @param providerKey A unique key which identifies a user on this provider (userID, email, ...).
 */
case class LoginInfo(providerID: String, providerKey: String)

/**
 * The companion object of the login info.
 */
object LoginInfo extends ((String, String) => LoginInfo) {
  implicit val primitive : Primitive[LoginInfo] = {
    Primitive.derive[LoginInfo, (String, String)] ( x => x.providerID -> x.providerKey) { x =>
      val ( a, b ) = x
      LoginInfo(a, b)
    }
  }
}
