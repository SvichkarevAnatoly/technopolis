from django.http import HttpResponse

from .models import Student


def students(request):
    student_list = Student.objects.all()
    output = "<br>".join(map(str, student_list))
    return HttpResponse(output)
