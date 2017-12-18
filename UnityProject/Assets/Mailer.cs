using UnityEngine;

public static class Mailer
{
    private const string AddressCs = "qkrsogusl3@gmail.com";

    private const string Chooser = "우편물을 선택하세요.";
    private const string Subject = "문의 메일";
    private const string Body = "템플릿 글 \n\n듣고 싶은 것을 써주세요";

    private const string MimeType = "message/rfc822";

#if UNITY_EDITOR

#elif UNITY_ANDROID
    private const string ClassName = "com.qkrsogusl3.mylibrary.AttachmentMailKt";
    private const string MethodName = "StartSelect";
#endif

    public static void StartSelect(string attachmentPath)
    {
#if UNITY_EDITOR

#elif UNITY_ANDROID
        using (var ajc = new AndroidJavaClass(ClassName))
        {
            ajc.CallStatic(MethodName, AddressCs, Subject, Body, MimeType, Chooser, attachmentPath);
        }   
#endif
    }
}
