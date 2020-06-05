package com.silky.quizzler

object Constant{

   const val USERNAME: String = "username"
    const val TOTAL_QUESTION: String = "total_questions"
   const val CORRECT_ANSWER : String = "correct_answer"

  fun getQuestions(): ArrayList<Questions> {

      val questionsList = ArrayList<Questions>()

      val que1 = Questions(
          1, "What country does this flag belong to?",
          R.drawable.ic_flag_of_argentina,
          "Argentina", "Australia",
          "Armenia", "Austria", 1
      )

      questionsList.add(que1)

      // 2
      val que2 = Questions(
          2, "What country does this flag belong to?",
          R.drawable.ic_flag_of_australia,
          "Angola", "Austria",
          "Australia", "Armenia", 3
      )

      questionsList.add(que2)

      // 3
      val que3 = Questions(
          3, "What country does this flag belong to?",
          R.drawable.ic_flag_of_brazil,
          "Belarus", "Belize",
          "Brunei", "Brazil", 4
      )

      questionsList.add(que3)

      // 4
      val que4 = Questions(
          4, "What country does this flag belong to?",
          R.drawable.ic_flag_of_belgium,
          "Bahamas", "Belgium",
          "Barbados", "Belize", 2
      )

      questionsList.add(que4)

      // 5
      val que5 = Questions(
          5, "What country does this flag belong to?",
          R.drawable.ic_flag_of_fiji,
          "Gabon", "France",
          "Fiji", "Finland", 3
      )

      questionsList.add(que5)

      // 6
      val que6 = Questions(
          6, "What country does this flag belong to?",
          R.drawable.ic_flag_of_germany,
          "Germany", "Georgia",
          "Greece", "none of these", 1
      )

      questionsList.add(que6)

      // 7
      val que7 = Questions(
          7, "What country does this flag belong to?",
          R.drawable.ic_flag_of_denmark,
          "Dominica", "Egypt",
          "Denmark", "Ethiopia", 3
      )

      questionsList.add(que7)

      // 8
      val que8 = Questions(
          8, "What country does this flag belong to?",
          R.drawable.ic_flag_of_india,
          "Ireland", "Iran",
          "Hungary", "India", 4
      )

      questionsList.add(que8)

      // 9
      val que9 = Questions(
          9, "What country does this flag belong to?",
          R.drawable.ic_flag_of_new_zealand,
          "Australia", "New Zealand",
          "Tuvalu", "United States of America", 2
      )

      questionsList.add(que9)

      // 10
      val que10 = Questions(
          10, "What country does this flag belong to?",
          R.drawable.ic_flag_of_kuwait,
          "Kuwait", "Jordan",
          "Sudan", "Palestine", 1
      )

      questionsList.add(que10)

      return questionsList
  }

}