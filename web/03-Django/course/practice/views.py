from django.http import HttpResponse
from django.template import loader

from .models import Student


def students(request):
    student_list = Student.objects.all()

    template = loader.get_template("practice/index.html")
    context = {'student_list': student_list}
    return HttpResponse(template.render(context, request))
