package epicode.u5d8hw.controllers;

import epicode.u5d8hw.entities.Blogpost;
import epicode.u5d8hw.exceptions.NotFoundException;
import epicode.u5d8hw.payloads.NewBlogPostPayload;
import epicode.u5d8hw.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    @Autowired
    BlogsService blogsService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Blogpost saveBlog(@RequestBody NewBlogPostPayload body) {
        return blogsService.save(body);
    }

    @GetMapping("")
    public List<Blogpost> getBlogs(@RequestParam(required = false) Integer authorId) {
        if(authorId != null) return blogsService.findByAuthor(authorId);
        else return blogsService.getBlogs();
    }

    @GetMapping("/{blogId}")
    public Blogpost findById(@PathVariable int blogId) {
        return blogsService.findById(blogId);
    }

    @PutMapping("/{blogId}")
    public Blogpost findAndUpdate(@PathVariable int blogId, @RequestBody NewBlogPostPayload body) {
        return blogsService.findByIdAndUpdate(blogId, body);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int blogId) {
        blogsService.findByIdAndDelete(blogId);
    }
}
