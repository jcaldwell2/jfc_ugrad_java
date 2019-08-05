/**
 * The type Address list.
 *
 * @author James Caldwell
 * @version 4 /24/2016
 */
public class AddressList {
    /**
     * This nested, private class represents a node of a singly linked list.
     */
    private class ListNode {
        private String name;
        private String tel; // Telephone number
        private String email;
        private String addr; // Address
        private String dob; // Date of birth
        private ListNode next; // Pointer to the next node

        private ListNode(String name, String tel, String email, String addr, String dob) {
            this.name = name;
            this.tel = tel;
            this.email = email;
            this.addr = addr;
            this.dob = dob;
        } // end of the constructor

        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Gets tel.
         *
         * @return the tel
         */
        public String getTel() {
            return tel;
        }

        /**
         * Gets email.
         *
         * @return the email
         */
        public String getEmail() {
            return email;
        }

        /**
         * Gets addr.
         *
         * @return the addr
         */
        public String getAddr() {
            return addr;
        }

        /**
         * Gets dob.
         *
         * @return the dob
         */
        public String getDob() {
            return dob;
        }

        /**
         * Sets name.
         *
         * @param name the name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Sets tel.
         *
         * @param tel the tel
         */
        public void setTel(String tel) {
            this.tel = tel;
        }

        /**
         * Sets email.
         *
         * @param email the email
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * Sets addr.
         *
         * @param addr the addr
         */
        public void setAddr(String addr) {
            this.addr = addr;
        }

        /**
         * Sets dob.
         *
         * @param dob the dob
         */
        public void setDob(String dob) {
            this.dob = dob;
        }

        /**
         * Gets next.
         *
         * @return the next
         */
        public ListNode getNext() {
            return next;
        }

        /**
         * Sets next.
         *
         * @param link the link
         */
        public void setNext(ListNode link) {
            next = link;
        }
    } // end of class ListNode
// ======================================
// Include your code here
//======================================

    private ListNode head;
    private ListNode currentNode;



    private boolean isEmpty() {

        if (head == null) {

            return true;
        }

        return false;
    }

    /**
     * Add node to front of the list.
     *
     * @param name    the name
     * @param tel     the tel
     * @param email   the email
     * @param address the address
     * @param dob     the dob
     */
    public void addToFront(String name, String tel, String email, String address, String dob) {

        ListNode node = new ListNode(name, tel, email, address, dob);
        if (!isEmpty()) {
            currentNode = head;
            head = node;
            head.setNext(currentNode);
            currentNode = head;

        } else {
            head = node;
            currentNode = head;
        }
    }

    /**
     * Add node to back of the list.
     *
     * @param name    the name
     * @param tel     the tel
     * @param email   the email
     * @param address the address
     * @param dob     the dob
     */
    public void addToBack(String name, String tel, String email, String address, String dob) {


        if (isEmpty()) {
            head = new ListNode(name, tel, email, address, dob);
            currentNode = head;
        } else if (currentNode.next == null) {
            currentNode.next = new ListNode(name, tel, email, address, dob);
            currentNode = head;
        } else {
            currentNode = currentNode.next;
            addToBack(name, tel, email, address, dob);
        }
    }

    public String toString() {

        String addressString = "";
        if (isEmpty()) {
            return "No matching data";
        }

        if (currentNode.next == null) {
            addressString += getCurrentNodeString(currentNode);
            currentNode = head;
            return addressString;

        } else {
            addressString += getCurrentNodeString(currentNode);
            currentNode = currentNode.next;
        }

        return addressString + toString();
    }

    /**
     * Reverse tostring string.
     *
     * @return the string
     */
    public String reverseToString() {


        return reverseToString(currentNode);


    }

    private String reverseToString(ListNode currentNode) {

        String returnString = "";

        if (isEmpty()) {
            return "Empty List";
        }


        if (currentNode.next == null) {
            returnString += getCurrentNodeString(currentNode);
            this.currentNode = head;
            return returnString;

        } else {
            returnString += getCurrentNodeString(currentNode);
        }


        return reverseToString(currentNode.next) + returnString;


    }

    /**
     * Reverse address list.
     *
     * @return the address list
     */
    public AddressList reverse() {

        reverse(currentNode);
        return this;
    }


    private void reverse(ListNode currentNode) {

        if (isEmpty())
            return;


        if (currentNode.next == null) {
            head = currentNode;
            this.currentNode = head;
            return;

        }

        reverse(currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null;
    }

    /**
     * Size of Address List.
     *
     * @return the int
     */
    public int sizeOf() {

        if (isEmpty()) {
            return 0;
        }


        if (currentNode.getNext() == null) {
            currentNode = head;
            return 1;
        } else {

            currentNode = currentNode.next;
        }
        return 1 + sizeOf();
    }

    /**
     * Phone number by name string.
     *
     * @param name the name
     * @return the string
     */
    public String phoneNumberByName(String name) {

        if (isEmpty()) {
            return "Address List is empty";
        }

        if (currentNode.getName().equalsIgnoreCase(name)) {
            String returnString = name + " has a phone number of " + currentNode.getTel();
            currentNode = head;

            return returnString;

        } else if (currentNode.next == null) {
            currentNode = head;
            return "No matching data";
        } else {
            currentNode = currentNode.next;
        }

        return phoneNumberByName(name);
    }

    /**
     * Email by name string.
     *
     * @param name the name
     * @return the string
     */
    public String emailByName(String name) {
        if (isEmpty()) {
            return "No matching data";
        }

        if (currentNode.getName().equalsIgnoreCase(name)) {
            String returnString = name + " has an email of " + currentNode.getEmail();
            currentNode = head;
            return returnString;
        } else if (currentNode.next == null) {
            currentNode = head;
            return "No matching data";
        } else {
            currentNode = currentNode.next;
        }

        return emailByName(name);
    }

    /**
     * Name by phone number string.
     *
     * @param tel the tel
     * @return the string
     */
    public String nameByPhoneNumber(String tel) {
        if (isEmpty()) {
            return "No matching data";
        }

        if (currentNode.getTel().equals(tel)) {
            String returnString = tel + " belongs to " + currentNode.getName();
            currentNode = head;
            return returnString;
        } else if (currentNode.next == null) {
            currentNode = head;
            return "No matching data";
        } else {
            currentNode = currentNode.next;
        }

        return nameByPhoneNumber(tel);
    }

    /**
     * Dob by name string.
     *
     * @param name the name
     * @return the string
     */
    public String dobByName(String name) {

        if (isEmpty()) {
            return "No matching data";
        }

        if (currentNode.getName().equalsIgnoreCase(name)) {
            String returnString = name + " has a birth date of " + currentNode.getDob();
            currentNode = head;
            return returnString;
        } else if (currentNode.next == null) {
            currentNode = head;
            return "No matching data";
        } else {
            currentNode = currentNode.next;
        }

        return dobByName(name);
    }

    private String getCurrentNodeString(ListNode node) {
        String addressString = "" + node.getName() + " " + node.getTel() + " " + node.getEmail() + " "
                + node.getAddr() + " " + node.getDob() + " \n";
        return addressString;
    }


} // end of class AddressList