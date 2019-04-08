# AndroidQ_RoleManager
### RoleManager
Android Q 버전의 새로운 API로서 기본 연결 프로그램을 편하게 설정할 수 있는 API

***

##### 주요 코드-1
<pre><code>val mRoleManager = getSystemService(RoleManager::class.java)
val isRoleAvailable = mRoleManager.isRoleAvailable(RoleManager.ROLE_GALLERY) // 해당 Role 사용가능 여부 확인
val isRoleHeld = mRoleManager.isRoleHeld(RoleManager.ROLE_GALLERY) // 해당 App이 설정 Role의 기본 프로그램으로 설정되었는지 확인
val mRoleIntent = mRoleManager.createRequestRoleIntent(RoleManager.ROLE_GALLERY) // Role Permission Intent 생성

startActivityForResult(mRoleIntent, ROLE_REQUEST_CODE) // 선언된 Intent로 startActivityForResult 메서드 실행
</code></pre>
##### 주요 코드-2
<pre><code>override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (requestCode == ROLE_REQUEST_CODE) {
        if (resultCode == RESULT_OK) {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show() // Permission 수락시
        } else {
            Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show() // Permission 거절시 Or Manifest 설정 오류시
        }
    }
}
</code></pre>
