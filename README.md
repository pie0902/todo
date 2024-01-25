
# TODO LIST

**[코드 리팩토링](https://github.com/pie0902/newTodo)📍**

## 🟢 개인과제

### 📋 개인과제 요구사항 설명

<aside> 🏁 **Goal: "나만의 일정 관리 앱 서버 만들기"**

</aside>
- **학습 과제를 끝내고 나면 할 수 있어요!**
    1. 구현하고자 하는 서비스의 전체적인 흐름을 파악하고 필요한 기능을 설계할 수 있습니다.
        1. Use Case Diagram, API 명세서, ERD를 작성할 수 있습니다.
    2. Spring Boot를 기반으로 CRUD(Create, Read, Update, Delete) 기능이 포함된 REST API를 만들 수 있습니다.

<aside> 🚩 **요구사항 확인: 필수 구현 기능**

</aside>

- [x] 일정 작성 기능
    - `할일 제목`,`할일 내용`, `담당자`, `비밀번호`, `작성일`을 저장할 수 있습니다.
    - 저장된 게시글의 정보를 반환 받아 확인할 수 있습니다.
        - 반환 받은 게시글의 정보에 `비밀번호`는 제외 되어있습니다.
- [ ] 선택한 일정 조회 기능
    - 선택한 일정의 정보를 조회할 수 있습니다.
        - 반환 받은 일정 정보에 `비밀번호`는 제외 되어있습니다.
- [x] 일정 목록 조회 기능
    - 등록된 일정 전체를 조회할 수 있습니다.
        - 반환 받은 일정 정보에 `비밀번호`는 제외 되어있습니다.
    - 조회된 일정 목록은 `작성일` 기준 내림차순으로 정렬 되어있습니다.
- [x] 선택한 일정 수정 기능
    - 선택한 일정의 `할일 제목`,`할일 내용`, `담당자`을 수정할 수 있습니다.
        - 서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달합니다.
        - 선택한 일정의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 수정이 가능합니다.
    - 수정된 일정의 정보를 반환 받아 확인할 수 있습니다.
        - 반환 받은 일정의 정보에 `비밀번호`는 제외 되어있습니다.
- [x] 선택한 일정 삭제 기능
    - 선택한 일정을 삭제할 수 있습니다.
        - 서버에 일정 삭제를 요청할 때 `비밀번호`를 함께 전달합니다.
        - 선택한 일정의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 삭제가 가능합니다.
### 🟢 Use Case Diagram

![UseCaseDiagram 1](https://github.com/pie0902/todo/assets/47919911/a2fc1934-a8a2-4040-b7f8-89c58f73d609)

### 🟢 API 명세서
| 기능 | Method | URL | request | response |  |
| ---- | ---- | ---- | ---- | ---- | ---- |
| 일정 등록 | POST | /api/todolist | {<br>'id':id,<br>'title':titll,<br>'contect':content,<br>'manager':manager,<br>'password':password,'<br>contentDate':contentDate<br>} | 일정등록 성공 or 실패 여부 |  |
| 할 일 조회 | GET | /api/todolist/{id} |  | 선택된 일정 조회 |  |
| 전체 조회 | GET | /api/todolists |  | 모든 일정 조회 |  |
| 할 일 수정 | PUT | /api/todolist/{id} | 'id':id,<br>'title':titll,<br>'contect':content<br>'password':password | 할 일 수정 성공 or 실패 여부 |  |
| 할 일 삭제 | DELETE | /api/todolist/{id} | ?id = {id} | 일정 삭제 성공 or 실패 여부 |  |

### 🟢 ERD

![todolist](https://github.com/pie0902/todo/assets/47919911/31633c91-2ba5-4021-bae0-860095116f2a)

### 😵‍💫 아쉬웠던 점/ 문제해결

#### 🟡 1.너무 빠른 진도
- 일단 18일 날 강의를 지급받았는데 강의는 총 2주 차 분량이다. 자바는 그렇다 쳐도 스프링의 개념을.. 이해하기엔 짧은 시간이라고 생각이 든다. 하지만 스프링이 대충 이런 것입니다라는 것을 경험시키려는 의도라면.. 나쁘진 않았다.
#### 👊 해결책 : 
* 관련 서적과 강의를 같이 구매해서 폭넓은 학습을 꾸준히 해야겠다.
- 이번주 주말을 이용해서 기초부터 다시 한번 복습해야 할 것 같다.
#### 🟡 2. Thymeleaf를 활용하지 못함
* 프로젝트를 생성할 때 Thymeleaf 라이브러리를 추가했는데 과제를 완성하려고 강의를 보면서 다른 것들을 구현하느라 Thymeleaf를 활용하지 못했다. 다행히 자바스크립트를 할 줄 알아서 간단하게 html을 만들어서 해결했지만 Thymeleaf의 매력을 알고 싶었다.
#### 👊 해결책 :
* 이번주 주말에 스프링을 처음부터 다시 공부하면서 Thymeleaf관련 자료도 공부하면 될 것 같다.
#### 🟡 3. @PathVariable & @RequestParam & @RequestBody
- 데이터를 전달하는 방식을 제대로 알고 사용하는 것이 아닌 것 같다고 생각이 들었다. 동적인 상황과 정적인 상황에서 제대로 사용해야 하는데 의미를 잘 모르고 사용했다.
#### 👊 해결책
~~~
@DeleteMapping("todos/{id}")  
public Long delete(@PathVariable Long id ,@RequestParam String password) {  
    TodoItem todoItem = findById(id);  
    if (todoItem != null) {  
        if (todoItem.getPassword().equals(password)) {  
            String sql = "DELETE FROM todolist WHERE id = ?";  
            jdbcTemplate.update(sql, id);  
        }  
        return id;  
    } else {  
        throw new IllegalArgumentException("선택한 할 일은 존재하지 않습니다.");  
    }  
}
~~~
- 위 코드는 삭제를 하는 api인데 id값은 @PathVariable로 비밀번호는 @RequestParam으로 받아왔다. 데이터를 받는 차이를 몰라서 비밀번호를 잘못된 방식으로 받아왔다.민감한 정보는 RequestBody로 받아야한다.
- 차이점을 알고 이해를 했다.
### 🟡 4.JdbcTemplate
- jdbc템플릿을 사용하면서 사실 이해가 잘 안 돼서 강의를 그대로 따라 했다. 이런 식으로 무엇을 만들면 무슨 소용이 있겠나.. 싶긴 했지만 이해하는 과정이라고 생각하면서 과제를 진행했더니 전체적인 구조를 조금을 알게 됐다. 하지만 아직도 이해가 완벽히 되지 않는 것이 현실이다.
#### 👊 해결책 :
* 이 문제도 마찬가지로 다시 처음부터 복습을 해야겠다.
### **✏️느낀점**
1. 사실문제는 더 많지만 지금은 아는 것보다 모르는 것이 더 많아서 모든 게 문제라고 생각이 든다. 위에 쓴 글들이 부정적으로 보일 수 있겠지만 이 또한 스프링과 친해지는 과정이라고 생각하며 아주 즐겁게 과제를 수행했다.
2. 스프링을 공부하면서 아직 갈길이 멀지만 완전히 나의 것으로 만들면 나의 개발생활이 매우 즐거워질 것이라고 생각이 들었다. 취업도 취업이지만 개발이 즐겁기 때문에 머릿속에 많아진 물음표들을 해결하는 과정이 기대된다.
3. 사고방식을 약간은 바꿔야지 스프링을 좀 더 익숙하게 받아들일 수 있을 것 같다. 그동안은
    1. 이론 - 실습 - 이해 > 2. 실습 - 이론 - 이해  
    1번 방식으로 공부를 했는데 , 오히려 익숙하지는 않지만 2번 방식이 스프링을 이해하는 데는 더 도움이 된 것 같다.
