import com.ff.SellerPasswordEncoderListener
import com.ff.okta.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    sellerPasswordEncoderListener(SellerPasswordEncoderListener)
    sellerPasswordEncoderListener(SellerPasswordEncoderListener)
    userPasswordEncoderListener(UserPasswordEncoderListener)
    userPasswordEncoderListener(UserPasswordEncoderListener)
}
