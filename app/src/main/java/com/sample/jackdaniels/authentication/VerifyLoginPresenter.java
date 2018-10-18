package com.sample.jackdaniels.authentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.sample.jackdaniels.products.ProductListActivity;
import com.sample.jackdaniels.util.NativeResourceManager;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class VerifyLoginPresenter implements VerifyLoginContract.VerifyLoginPresenter {

    private VerifyLoginContract.VerifyLoginView view;
    private VerifyLoginContract.Navigator navigator;
    private NativeResourceManager nativeResourceManager;
    private String mobileNumber;


    VerifyLoginPresenter(VerifyLoginContract.VerifyLoginView view, String mobileNumber, VerifyLoginContract.Navigator navigator,
                         NativeResourceManager nativeResourceManager ){
        this.view = view;
        this.nativeResourceManager = nativeResourceManager;
        this.navigator = navigator;
        this.mobileNumber = mobileNumber;
        view.setPresenter(this);
        view.initFireBaseAuth();
        sendVerificationCode(mobileNumber);
    }

    @Override
    public void onStart() {
        view.initFireBaseAuth();
        sendVerificationCode(mobileNumber);

    }

    @Override
    public void sendVerificationCode(String mobile) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + mobile,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                OnVerificationStateChangedCallbacks());
    }

    @Override
    public void verifyVerificationCode(String code) {
        //creating the credential
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(view.getVerificationId(), code);

        //signing the user
        view.signInWithPhoneAuthCredential(credential);
    }



    @Override
    public PhoneAuthProvider.OnVerificationStateChangedCallbacks OnVerificationStateChangedCallbacks() {
        //the callback to detect the verification status
        PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                view.dismissProgress();
                //Getting the code sent by SMS
                String code = phoneAuthCredential.getSmsCode();

                //sometime the code is not detected automatically
                //in this case the code will be null
                //so user has to manually enter the code
                if (code != null) {
                    view.setCode(code);

                    //verifying the code
                    verifyVerificationCode(code);
                }
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                view.dismissProgress();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                view.dismissProgress();
                //storing the verification id that is sent to the user
                view.setVerificationId(s);
            }
        };

        return mCallbacks;
    }

    @Override
    public void onClick() {
        view.showProgress("Verifying OTP");
        String code = view.getCode();
        if (code.isEmpty() || code.length() < 6) {
            view.setErrorMessage();
            return;
        }
        //verifying the code entered manually
        verifyVerificationCode(code);
    }


}
