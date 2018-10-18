package com.sample.jackdaniels.authentication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.sample.jackdaniels.base.BaseNavigator;
import com.sample.jackdaniels.base.BasePresenter;
import com.sample.jackdaniels.base.BaseView;

public interface VerifyLoginContract {

    public interface VerifyLoginView extends BaseView<VerifyLoginContract.VerifyLoginPresenter> {

        void showProgress(String message);

        void dismissProgress();

        void initFireBaseAuth();

        void setCode(String code);

        void setVerificationId(String verificationId);

        String getVerificationId();

        FirebaseAuth getFirebaseAuth();

        String getCode();

        void setErrorMessage();

        void signInWithPhoneAuthCredential(PhoneAuthCredential credential);
    }

    public interface VerifyLoginPresenter extends BasePresenter {
        void sendVerificationCode(String mobile);
        void verifyVerificationCode(String code);
//        void signInWithPhoneAuthCredential(PhoneAuthCredential credential);
        PhoneAuthProvider.OnVerificationStateChangedCallbacks OnVerificationStateChangedCallbacks();
        void onClick();
    }

    interface Navigator extends BaseNavigator {
        void callProductListScreen(Class<?> destination);
    }
}
