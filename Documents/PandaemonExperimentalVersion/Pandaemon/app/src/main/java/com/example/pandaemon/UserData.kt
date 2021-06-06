package com.example.pandaemon

abstract class UserData {

    abstract var submitionDate : Int // Η Ημερομηνία Δημιουργίας του Ραντεβού αναπαρίσταται σε μορφή integer 8 ψηφίων, μιας και δεν υπάρχει τύπος δεδομένων
    // για ημερομηνίες ξεχωριστά, και θα είναι της μορφής DDMMYYYY , όπου DD: τα 2 ψηφία μέρας , MM: τα 2 ψηφία του μήνα και YYYYY τα 4 ψηφία του έτους.
    abstract var submissionId: Int
    abstract var submitter: String
    abstract var reviewStatus: Boolean
    abstract var reviewerId: Int
    abstract var reviewDate : Int // Η Ημερομηνία Δημιουργίας του Ραντεβού αναπαρίσταται σε μορφή integer 8 ψηφίων, μιας και δεν υπάρχει τύπος δεδομένων
    // για ημερομηνίες ξεχωριστά, και θα είναι της μορφής DDMMYYYY , όπου DD: τα 2 ψηφία μέρας , MM: τα 2 ψηφία του μήνα και YYYYY τα 4 ψηφία του έτους.
    abstract var reviewVerdict: String  // Κατάσταση που θα ανανεώνει ο reviewer και μπορεί να είναι "Υπό Εξέταση","Αποδεκτό" ,"Μη αποδεκτό" .


}