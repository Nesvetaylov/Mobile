import androidx.lifecycle.ViewModel

class ContactViewModel : ViewModel() {
    private val contacts = mutableListOf<Contact>()
    private var currentIndex = 0

    data class Contact(
        var name: String = "",
        var phone: String = "",
        var email: String = "",
        var address: String = ""
    )

    fun addContact(contact: Contact) {
        contacts.add(contact)
        currentIndex = contacts.size - 1
    }

    fun updateContact(contact: Contact) {
        if (contacts.isNotEmpty()) {
            contacts[currentIndex] = contact
        }
    }

    fun getCurrentContact(): Contact {
        return if (contacts.isNotEmpty()) contacts[currentIndex] else Contact()
    }

    fun moveToNext(): Boolean {
        if (currentIndex < contacts.size - 1) {
            currentIndex++
            return true
        }
        return false
    }

    fun moveToPrevious(): Boolean {
        if (currentIndex > 0) {
            currentIndex--
            return true
        }
        return false
    }

    fun hasContacts(): Boolean = contacts.isNotEmpty()
}