/*
* The LinkedStacj class represents a last-in-first-out Stack 
* of either String or Integer values.
*/
function Node() {
    this.string = undefined;
    this.int = undefined;
    this.next = undefined;
}



/*
 * Initializes an empty stack.
 * 
 * StringOrInt - should be set to "String" if wanting a stack of type String or "Integer" if wanting a stack of type Integer
 */
function LinkedStakc(StringOrInt) {
    this.first = undefined;
    this.N = 0;
    this.stringOrInt = StringOrInt;
}

/*
 * Add item to this stack
 */
LinkedStakc.prototype.push = function (item) {
    var oldfirst = this.first;
    this.first = new Node();
    this.N++;
    
    if (this.stringOrInt == "string") {
        this.first.string = item;
    } else if (this.stringOrInt == "integer") {
        this.first.int = item;
    } else {
        throw "Unrecognized type";
    }
    this.first.next = oldfirst;
}

/*
 * Returns number of items in Stack
 */
LinkedStakc.prototype.size = function () {
    var numOfNodes = 0;
    for (; this.first != null; this.first = this.first.next, numOfNodes++) {}
    return numOfNodes;
}

var stack = new LinkedStakc("integer");
stack.push(5);
window.alert(stack.size());

// Find the minimum length substring in a string S that contains all of the characters in string Y

function foo (s, y) {

    // returns substring of S that contains all of the characters in Y

    // s = "aabbcc";
    // y = "bca";
    // output = abbc

    // [a,b,c]+
    // var windows = y.size()

    // brute force method
    // shifting window method
    // O(n^2)




    for(var window = y.length ; window<s.length ; window++ ){ // increase window size
        for(var start = 0 ; start<s.length - ( window -1) ; start++) { // shift the window down
            if( match(s.substring( start, start+window ) ,  y) ){
                return s.substring(start, start+window);
            }
        }
    }
}

// checks if y matches to st. 
function match(st, y) {
    // [a,b,c]+
    // st , y in any order true


    st.incluDes a && st includes b  && st includes c

    // st.matches(y)
    return false;
}


let start =0
let end =0
let length = Integer.MAX_VALUE;
//  Math.min(length, start,end);

Map ( a:-1 b:-1 c:-1 ) {
    
}


aabbcc

1 3 4

start = Min (1, 3,4)
end = Max (1,3,4)
length = Min(length, end-start);

trie 
Node( 
    String 
)


// Find the maximum sum of any path in a binary tree


2
/     \
3       5