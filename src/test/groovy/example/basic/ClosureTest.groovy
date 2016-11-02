package example.basic

import org.junit.Test

class ClosureTest {

	@Test
	void testListSort() {
		List<String> list = ["John", "Wilson", "Albert", "Robert", "Louis", "Paul", "Dennis"]

		assert ["Albert", "Dennis", "John", "Louis", "Paul", "Robert", "Wilson"] == list.sort()
		assert ["John", "Paul", "Louis", "Albert", "Dennis", "Robert", "Wilson"] == list.sort { name -> name.length() }
		assert ["Paul", "John", "Louis", "Wilson", "Robert", "Dennis", "Albert"] == list.sort { name1, name2 -> name1.length() <=> name2.length() ?: name2 <=> name1 }
	}

	@Test
	void testListReduce() {
		List<String> list = ["John", "Wilson", "Albert", "Robert", "Louis", "Paul", "Dennis"]

		assert [4, 6, 6, 6, 5, 4, 6] == list.collect { name -> name.length() }
	}
	
	@Test
	void testListFilter() {
		List<String> list = ["John", "Wilson", "Albert", "Robert", "Louis", "Paul", "Dennis"]

		assert ["Wilson", "Albert", "Robert", "Dennis"] == list.findAll { name -> name.length() == 6 }
	}
	
	@Test
	void testSum() {
		List<Integer> nums = [8, 3, 5, 1, 4, 2, 7, 9, 6]
		
		assert 45 == nums.sum()
		assert 90 == nums.sum { num -> num * 2 }
		assert 90 == nums.sum({ num -> num * 2 })
		assert 90 == nums.sum() { num -> num * 2 }
		assert 90 == (nums*.intValue() * 2).sum()

		assert 25 == nums.findAll { num -> num % 2 != 0 }.sum() // sum only odd numbers
		assert 20 == nums.findAll { num -> num % 2 == 0 }.sum() // sum only even numbers
	}
	
}
