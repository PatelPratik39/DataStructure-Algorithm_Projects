
const Node = require("./Node");

class LinkedList {
  constructor() {
    this.head = null;
  }

  append(data) {
    const newNode = new Node(data);
    if (!this.head) {
      this.head = newNode;
      return;
    }

    let currentNode = this.head;
    while (currentNode.next) {
      currentNode = currentNode.next;
    }
    currentNode.next = newNode;
  }

  find(predicate) {
    let currentNode = this.head;
    while (currentNode) {
      if (predicate(currentNode.data)) {
        return currentNode.data;
      }
      currentNode = currentNode.next;
    }
    return null;
  }
}

module.exports = LinkedList;