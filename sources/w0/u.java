package w0;

import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.RestrictedInheritance;
import l1.g;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", explanation = "Use canonical fakes instead.", link = "go/gmscore-restrictedinheritance")
@DoNotMock("Use canonical fakes instead. go/cheezhead-testing-methodology")
public interface u {
    g<Void> a(s sVar);
}
