package self.philbrown.gsonparceable;

import android.os.Parcel;
import android.test.InstrumentationTestCase;

/**
 * TODO Description
 *
 * @author Phil Brown
 * @since 1:49 PM Aug 14, 2015
 */
public class ParcelingTest extends InstrumentationTestCase {

    public void testParceling() {
        Contact contact = new Contact();
        contact.setName("John Doe");
        contact.setEmail("jdoe@fakedomain.com");
        contact.setFavorite(true);
        Parcel parcel = Parcel.obtain();
        contact.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);

        Contact parceledContact = Contact.CREATOR.createFromParcel(parcel);
        assertEquals(contact, parceledContact);
    }
}
