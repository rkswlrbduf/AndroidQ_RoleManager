package blackstone.com.myrolemanager

import android.app.role.RoleManager
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val ROLE_REQUEST_CODE = 2002
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        text.setOnClickListener {
            val mRoleManager = getSystemService(RoleManager::class.java)
            val isRoleAvailable = mRoleManager.isRoleAvailable(RoleManager.ROLE_GALLERY)
            val isRoleHeld = mRoleManager.isRoleHeld(RoleManager.ROLE_GALLERY)
            Log.d("TAG", "isRoleAvailable : ${isRoleAvailable}, isRoleHeld : ${isRoleHeld}" )
            val mRoleIntent = mRoleManager.createRequestRoleIntent(RoleManager.ROLE_GALLERY)
            startActivityForResult(mRoleIntent, ROLE_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ROLE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
