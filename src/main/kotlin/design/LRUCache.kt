package design

data class CacheNode(val key: Int, var value: Int) {
    var prev: CacheNode? = null
    var next: CacheNode? = null
}

class LRUCache(private val capacity: Int) {
    private val map = mutableMapOf<Int, CacheNode>()
    private var queueHead: CacheNode? = null
    private var queueTail: CacheNode? = null

    private fun promoteToHead(node: CacheNode) {
        when {
            node == queueHead -> return //node is first
            node == queueTail -> queueTail = node.prev //node is last
            node.prev != null && node.next != null -> { //node is in the middle
                    node.prev!!.next = node.next
                    node.next!!.prev = node.prev
            }
        }
        node.next = queueHead
        queueHead!!.prev = node
        queueHead = node
    }

    private fun evictFromTail() {
        queueTail = queueTail!!.prev
    }

    //O(1)
    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        promoteToHead(node)
        return node.value
    }

    //O(1)
    fun put(key: Int, value: Int) {
        val node: CacheNode
        if (key in map) {
            node = map[key]!!
            node.value = value
        } else {
            node = CacheNode(key, value)
            map[key] = node
        }
        if (queueHead == null) {
            queueHead = node
            queueTail = node
        }
        promoteToHead(node)

        if (map.size > capacity) {
            map.remove(queueTail!!.key)
            evictFromTail()
        }
    }
}

fun main() {
    val lRUCache = LRUCache(2)
    lRUCache.put(1, 1) // cache is {1=1}
    lRUCache.put(2, 2) // cache is {1=1, 2=2}
    println(lRUCache.get(1)) // return 1
    lRUCache.put(3, 3) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    println(lRUCache.get(2)) // returns -1 (not found)
    lRUCache.put(4, 4) // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    println(lRUCache.get(1)) // return -1 (not found)
    println(lRUCache.get(3)) // return 3
    println(lRUCache.get(4)) // return 4
}
