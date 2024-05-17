package com.example.cardiopediafyp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class chatbotActivity extends AppCompatActivity {

    private TextView welcomeTextView;
    private LinearLayout chatLinearLayout;
    private EditText userInputEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        welcomeTextView = findViewById(R.id.welcomeTextView);
        chatLinearLayout = findViewById(R.id.chatLinearLayout); // Make sure this is correctly defined in your layout XML
        userInputEditText = findViewById(R.id.userInputEditText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMessage = userInputEditText.getText().toString();
                String botResponse = getBotResponse(userMessage);
                updateChatView(userMessage, botResponse);
                userInputEditText.setText("");

                if (welcomeTextView.getVisibility() == View.VISIBLE) {
                    welcomeTextView.setVisibility(View.GONE);
                }
            }
        });
    }

    private String getBotResponse(String userMessage) {
        // Simulate bot responses here
        if (userMessage.toLowerCase().contains("hello")) {
            return "\nHello! How can I assist you?\n"+"==Welcome into Digital Pakistan Help Center==\n"
                    +"1. Documents Required for CNIC\n"+
                    "2. Documents Required for BFORM\n"+
                    "3. Eligibility Required for CNIC\n"+
                    "4. Documents Required for PASSPORT\n"+
                    "5. Documentation Required for Learner Permit\n"+
                    "6. Process and fees for CNIC\n"+
                    "7. Process and fees for  Passport \n"+
                    "8. Process and fees for Learner Permit\n"+
                    "9. Other\n"+
                    "===================================="
                    ;
        } else if (userMessage.toLowerCase().contains("how are you")) {
            return "\nI'm just a chatbot, but I'm here to help!";
        } else if (userMessage.toLowerCase().contains("1")) {
            return "* \nFully Filled Application Form\n"+
                    "* Passport Size Photo of CNIC Holder.\n"+
                    "* Applicant must be 18 years of age or older.\n"+
                    "* Applicant must have proof of address in Pakistan.\n"+
                    "* One valid and Attested Copy of both father CNIC\n" +
                    "* Applicant must have paid the prescribed fee for the NIC application form and processing fee (currently Rs 750/-).(PSID)\n"
                    ;
        }
        else if (userMessage.toLowerCase().contains("2")) {
            return "* \nCNIC-S/NICOP of any one of Parents\n"+
                    "* 1 x Passport Size Photos\n"+
                    "* Fully filled Application Form\n"+
                    "* You can apply for Child Registration Certificate (CRC) by going to the nearest NADRA Registration Center (NRC).\n" +
                    "\n" +
                    "Following are the steps which you will be following at the NRC:\n" +
                    "\n" +
                    "    You will be issued a token\n" +
                    "    Your photograph will be captured\n" +
                    "    Your fingerprints and signature will be taken\n" +
                    "    Your required data entry will be done and form will be printed to be reviewed by yourself\n" +
                    "    You will be handed over a printed version of your application form.\n";
        }
        else if (userMessage.toLowerCase().contains("3")) {
            return "\nEligibility Requirements\n"+
                    "When any one of the parents or blood relative who is an ID Card holder but not present and documents are not available\n" +
                    "\n" +
                    "    Presence of applicant.\n" +
                    "    Original CNIC of parent/blood relative/grandparent.\n" +
                    "    Biometric witness of any CNIC holder along with affidavit and interview to satisfy case officer.\n" +
                    "    Attested CNICF (Computerized Identity Card Form).\n";
        }
        else if (userMessage.toLowerCase().contains("4")) {
            return "\n" +
                    "\nPassport Requirements\n" +
                    "\n" +
                    "    Evidencing proof of prescribed passport fee payment, through Original Bank Paid Fee Challan (receipt) or e-Payment Confirmation Detail (SMS/Email along with PSID No.)\n" +
                    "    Original Valid CNIC/NICOP with a photocopy.\n" +
                    "    Previous Passport in original with its photocopy, (if issued).\n" +
                    "    NOC (No Objection Certificate) from the concerned department in case of government, semi-government or autonomous body employees.\n" +
                    "    Foreign Passport along with its photocopy, (for Dual-Nationals only).\n" +
                    "    In case of a Lost passport, bring a Lost passport Police report mentioning the previous passport number.\n" +
                    "\n"+
                    "FOR MORE VISIT:-https://dgip.gov.pk/passport/ordinary-passport.php\n";
        }
        else if (userMessage.toLowerCase().contains("5")) {
            return "\nRequired Documents:\n" +
                    "\n" +
                    "Original and 1 Copy of CNIC\n" +
                    "Get a Code Book of Traffic Rules & Regulation from Traffic Police Office.\n" +
                    "Medical Certificate (for the candidates of 50 years or more)\n" +
                    "\n" +
                    "Age Limits for Learner Permit:\n" +
                    "\n" +
                    "Motor Cycle/ Motor Car: 18 Years\n" +
                    "LTV (Rikshaw, Taxi, Tractor Commercial): 21 Years\n" +
                    "Note: Learner permits are issued on Daily Bases which Validity is of 6 months.\n" +
                    "\n" +
                    "\nProcessing Fee:\n" +
                    "\n" +
                    "    A Ticket of Rs.60 from any Post Office.\n" +
                    "\n" +
                    "\nTurn Around Time:\n" +
                    "\n" +
                    "    Around 15 minutes, on spot delivery\n" +
                    "\n";
        }
        else if (userMessage.toLowerCase().contains("6")) {
            return "\nOnline Process of getting NIC by visiting Pak Identity website\n" +
                    "\n" +
                    "You can apply for your Smart National Identity Card (SNIC) by visiting Pak Identity website and have it delivered to your doorstep. Please note that you cannot apply for fresh/new CNIC from the website. You can only get renewed and modified NIC from the online process.\n" +
                    "\n" +
                    "The Pak-Identity website allows you to easily acquire your National ID in 3 simple steps:\n" +
                    "\n" +
                    "    STEP 1: Registration\n" +
                    "\n" +
                    "Register an account on the Pak-Identity web application. You can access it using the Apply Now button on the homepage. You need to give a valid mobile number and email address for account verification.\n" +
                    "\n" +
                    "    STEP 2: Fee Submission\n" +
                    "\n" +
                    "Depending on your application category, you will be asked to pay your fee at either the start or the end of the application (varies between application types). We accept all major Credit & Debit Cards.\n" +
                    "\n" +
                    "    STEP 3: Online Application\n" +
                    "\n" +
                    "Complete your application and make sure all provided information is correct. Upload your photograph, fingerprints and supporting documents. Instructions on how to upload documents are available on the homepage under each application category.\n" +
                    "And you are done!\n" +
                    "Your Application will be processed by NADRA and the ID Card shall be delivered at your address. You may be contacted in case any further information is required.\n" +
                    "\n" +
                    "Note: This information is taken from the official website of NADRA.!";
        }
        else if (userMessage.toLowerCase().contains("7")) {
            return "\n" +
                    "\nOnline Application\n" +
                    "\n" +
                    "You are now ready to apply online.\n" +
                    "\n" +
                    "Now, you have to:\n" +
                    "\n" +
                    "    Click on the Get Started button.\n" +
                    "    Register your account :\n" +
                    "        In case you are within Pakistan, an SMS and email code will be sent to you for registration.\n" +
                    "        In case you are abroad all required codes will be sent via email only.\n" +
                    "\n" +
                    "NOTE: Users already registered in Pak-identity system can log in from their registered Pak-identity “Username” and “Password”\n" +
                    "\n" +
                    "        Create an application for your machine readable passport and provide details for your application.\n" +
                    "        Provide your address for machine readable passport delivery.\n" +
                    "        Pay Fee through a Credit Card/Debit Card (Visa/Master only).\n" +
                    "\n" +
                    "NOTE: DGI&P has a NO REFUND POLICY against any application initiated/submitted for issuance of Machine readable passport. Applicant is requested to thoroughly review information and guidelines provided in the website\n" +
                    "\n" +
                    "    Provide the required personal details.\n" +
                    "\n" +
                    "NOTE: : Currently the home delivery option is only available for overseas Pakistanis\n" +
                    "\n" +
                    "    For inland applicants passports will be delivered at preferred RPOs/EPOs\n" +
                    "\n" +
                    "    Provide your present and permanent addresses.\n" +
                    "    Upload your photograph.\n" +
                    "    Upload the supporting documents required by the application.\n" +
                    "    Download the form, capture the 4 fingerprints asked by the system.\n" +
                    "    Set the scanner at 600 DPI, JPEG/JPG and Grayscale. Scan and upload the form.\n" +
                    "    Review the information you provided, sign the declaration and then submit the application.\n";
        }
        else if (userMessage.toLowerCase().contains("8")) {
            return "\nI'm just a chatbot, but I'm here to help!";
        }
        else if (userMessage.toLowerCase().contains("9")) {
            return "\n FOR FURTHER CONTACT AND QUERIES FEEL FREE TO ASK:-\n" +
                    "✉️ digitalpakapp@gmail.com\n"+
                    "☎ 052838499939\n";
        }

        else {
            return "\nHello! How can I assist you?\n"+"==Welcome into Digital Pakistan Help Center==\n"
                    +"1. Documents Required for CNIC\n"+
                    "2. Documents Required for BFORM\n"+
                    "3. Eligibility Required for CNIC\n"+
                    "4. Documents Required for PASSPORT\n"+
                    "5. Documentation Required for Learner Permit\n"+
                    "6. Process and fees for CNIC\n"+
                    "7. Process and fees for  Passport \n"+
                    "8. Process and fees for Learner Permit\n"+
                    "9. Other\n"+
                    "===================================="
                    ;
        }
    }

    private void updateChatView(String userMessage, String botResponse) {
        // Create user message TextView
        TextView userMessageTextView = new TextView(this);
        userMessageTextView.setText("User: " + userMessage);
        userMessageTextView.setBackgroundResource(R.drawable.bg_user_message);
        userMessageTextView.setTextColor(Color.WHITE);
        userMessageTextView.setPadding(16, 8, 16, 8);
        LinearLayout.LayoutParams userParams = new LinearLayout.LayoutParams(
                getResources().getDimensionPixelSize(R.dimen.user_message_width),
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        userParams.gravity = Gravity.START;
        userMessageTextView.setLayoutParams(userParams);
        chatLinearLayout.addView(userMessageTextView);

        // Create bot message TextView
        TextView botMessageTextView = new TextView(this);
        botMessageTextView.setText("Bot: " + botResponse);
        botMessageTextView.setBackgroundResource(R.drawable.bg_bot_message);
        botMessageTextView.setTextColor(Color.WHITE);
        botMessageTextView.setPadding(16, 8, 16, 8);
        LinearLayout.LayoutParams botParams = new LinearLayout.LayoutParams(
                getResources().getDimensionPixelSize(R.dimen.bot_message_width),
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        botParams.gravity = Gravity.END;
        botParams.topMargin = getResources().getDimensionPixelSize(R.dimen.bot_message_margin_top); // Set the top margin here
        botMessageTextView.setLayoutParams(botParams);
        chatLinearLayout.addView(botMessageTextView);
    }
}